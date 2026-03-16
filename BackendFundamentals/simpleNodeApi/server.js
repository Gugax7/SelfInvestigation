const http = require("http");
const { chat } = require("./data/messages");
const { users } = require("./data/users")

const getUser = (id, password) => {
  const currentUser = users.find((user) => user.id === id);

  if(currentUser.password === password){
    return currentUser;
  }

  return undefined
}

const server = http.createServer((req, res) => {

  if(req.method.toUpperCase() === 'POST'){

    let body = '';

    req.on('data', (chunk) => {
      body+= chunk.toString();
    });

    req.on('end', () => {
      try{

        const parsedBody = JSON.parse(body)

        console.log("body password: ", parsedBody.password);
        console.log("body id: ", parsedBody.id);

        if(!parsedBody.id || !parsedBody.password){
          res.writeHead(403, {"Content-type":"text/plain"});
          res.end("Username or password incorrect")
          return;
        }

        const user = getUser(parsedBody.id, parsedBody.password);

        if(!user){
          res.writeHead(403, {"Content-type":"text/plain"});
          res.end("Username or password incorrect")
          return;
        }

        if(!parsedBody.message || parsedBody.message === ''){
          res.writeHead(400, {"Content-type":"text/plain"});
          res.end("Empty message!")
          return;
        }

        const message = {user:user.name, sent:parsedBody.message};

        chat.push(message);

        res.writeHead(200, {"Content-type":"text/plain"});
        res.end("Message sent successfully")
      }
      catch(error){
        throw error;
      }
    })

    return;
  } 

  if(req.method.toUpperCase() === 'GET'){
    res.writeHead(200, {"Content-type":"application/json"});
    res.end(JSON.stringify(chat));
    return
  }

  else{
    res.writeHead(404, {"Content-type":"text/plain"});
    res.end("Method not found!");

  }

  return;
});



server.listen(3000, () => console.log("Server is running on http://localhost:3000"));