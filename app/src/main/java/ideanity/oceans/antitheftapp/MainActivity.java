package ideanity.oceans.antitheftapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

    public class MainActivity extends AppCompatActivity {

        private EditText usernameEditText;
        private EditText passwordEditText;
        private Button loginButton;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            usernameEditText = findViewById(R.id.editTextUsername);
            passwordEditText = findViewById(R.id.editTextPassword);
            loginButton = findViewById(R.id.buttonLogin);

            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String username = usernameEditText.getText().toString();
                    String password = passwordEditText.getText().toString();

                    if (isValidCredentials(username, password)) {
                        // Successful login, navigate to the main activity or perform desired actions
                        Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, LoadActivity.class);
                        startActivity(intent);
                    } else {
                        // Invalid credentials, show an error message or perform appropriate actions
                        Toast.makeText(MainActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        private boolean isValidCredentials(String username, String password) {
            // Perform your validation logic here, such as checking against a database or web service
            // Return true if the credentials are valid, otherwise return false
            return username.equals("admin") && password.equals("password");
        }
    }
