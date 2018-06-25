const express = require('express');
const router = express.Router();

/* GET api listing. */
router.post('/authenticate', (req, res) => {
  let user_name = req.body.username;
  let password = req.body.password;

  if(user_name === "abhi" && password === "abc@123") {
    res.send({"auth":true});
  }
  res.send({"auth":false});

});

module.exports = router;
