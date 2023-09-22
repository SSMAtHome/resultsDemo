# resultsDemo

* Prerequisites
    * Java 17

* build instructions
    * Compile with ./mvnw package
    * Run with java -jar target/resultsDemo-0.0.1-SNAPSHOT.jar

Sample requests

```
(
  async function createResult(){
    let result = {
      "system": "Olympic",
      "name": "football",
    };
    await fetch('http://localhost:8080/resultss',{
      method:"POST",
      headers:{
        Accept: 'application/json',
        'Content-Type': 'application/json',
      },     
      body: JSON.stringify(result)
    })
    .then( result=> result.text())
    .then( text=> console.log(text) )
  })();
```

```
(
  async function getResultss(){
    let result = {
        "system": "Olympic",
        "name": "football",
        "from": 1687704841,
        "to": 1687704869
      };
      await fetch('http://localhost:8080/results',{
        method:"GET",
        headers:{
          Accept: 'application/json',
          'Content-Type': 'application/json',
        },    
        body: JSON.stringify(result)
    }).then( result=> result.text())
    .then( text=> console.log(text) )
  })();
```
