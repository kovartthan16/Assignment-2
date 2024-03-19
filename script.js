// Create a users array with below objects
var users = [
    {
      username: 'user1',
      password: 'password1',
    },
    {
      username: 'user2',
      password: 'password2',
    },
    {
      username: 'user3',
      password: 'password3',
    },
  ];
  
  // Create a function onRememberMeChange, if the remember me is checked, show the alert messsage "You will be remembered!"
  function onRememberMeChange() {
    var remember = document.getElementsByName('remember')[0].checked;
    if (remember) {
      alert('You will be remembered!');
    }
  }
  
  // Create a function login
  function login() {
    // Get the username and password from the form
    var username = document.getElementById('uname').value;
    var password = document.getElementById('psw').value;
    var remember = document.getElementsByName('remember')[0].checked;
  
    // Check whether the username and password are empty
    if (username === '' || password === '') {
      document.getElementById('error').innerHTML =
        'Username and Password should not be empty';
      return;
    }
  
    // Check whether the remember me is checked
    if (!remember) {
      document.getElementById('error').innerHTML =
        'Remember Me should be checked';
      return;
    }
  
    // Check whether the username and password exists in users array
    var user = users.find(function (user) {
      return user.username === username && user.password === password;
    });
  
    // If not exists, clear the success message and display the error message
    // else clear the error message and display the success message
    if (!user) {
      document.getElementById('success').innerHTML = '';
      document.getElementById('error').innerHTML =
        'Invalid credentials. Please try again.';
      return;
    } else {
      document.getElementById('error').innerHTML = '';
      document.getElementById('success').innerHTML =
        'Login successful! Welcome, ' + username;
    }
  }
  