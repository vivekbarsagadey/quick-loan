const express = require('express');
const router = express.Router();

/* GET api listing. */
router.post('/authenticate', (req, res) => {
  let user_name = req.body.username;
  let password = req.body.password;

  if(user_name === "abhi" && password === "abc@123") {
    let response = {
      auth : true,
      company : "Whiz IT Services",
      username : "abhi",
      email : "abhinands.shetty@gmail.com",
      first_name : "Abhinand",
      last_name : "Shetty",
      address : "Pune City, Maharashtra",
      city: "Pune",
      country : "India",
      postal_code : "411016",
      about_me : "Talk is boring. Show me the code!"
    }
    res.send(response);
  }
  res.send({"auth":false});

});

module.exports = router;
