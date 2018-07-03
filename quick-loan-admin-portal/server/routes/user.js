const express = require('express');
const router = express.Router();
const userStore = require('../stores/userstore');
/* GET api listing. */
router.post('/authenticate', (req, res) => {
  let user_name = req.body.username;
  let password = req.body.password;
  userStore.authenticate({username:user_name , password : password}).then((user)=>{
    if (user){
      res.send({"auth":true, user : user});
    }
    else{
      res.send({"auth":false ,user :null});
    }
  });
});

module.exports = router;
