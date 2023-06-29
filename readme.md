## Materiel
- post : http://localhost:8080/materiel/create

body's example:
```
    {
        "id": "M003",
        "design": "Meizu M3S",
        "about": "Cam 40Mp, ROM: 16GB, RAM 3GB",
        "state": "BON"
    }
```
- get  http://localhost:8080/materiel/read
- get  http://localhost:8080/materiel/read/{id}
- put http://localhost:8080/materiel/update/{id}

body's example:
```
    {
        "design": "Meizu M3S",
        "about": "Cam 40Mp, ROM: 16GB, RAM 3GB",
        "state": "BON"
    }
```
- delete http://localhost:8080/materiel/delete/{id}
- get http://localhost:8080/materiel/state

return values:
```[
	{
		"etat": "BON",
		"compte": 3
	},
	{
		"etat": "MAUVAIS",
		"compte": 1
	}
]
```

## Intervenant
- post : http://localhost:8080/intervenant/create
  
  requestBody :
    ```
        {
            "id": "I001"
            "name": "Peter Parker",
            "taux": 10
        }
    ```
- get : http://localhost:8080/intervenant/read
- get : http://localhost:8080/intervenant/read/{id}
- put :  http://localhost:8080/intervenant/update/{id}
  
  requestBody :
    ```
        {
            "name": "Peter JackSon",
            "taux": 10
        }
```
- delete : http://localhost:8080/intervenant/delete/{id}
  
## Entretien
- post : http://localhost:8080/entretien/create
  
  body's example:
	```{
		"date": "2023-06-27",
		"hours": 5,
		"intervenant": {
			"id": "I006",
			"name": "Jean Claude",
			"taux": 10,
			"entretien": []
		},
		"materiel": {
			"id": "M003",
			"design": "Meizu M3S",
			"about": "Cam 40Mp, ROM: 16GB, RAM 3GB",
			"state": "BON",
			"entretien": []
		}
	}```
- get : http://localhost:8080/entretien/read
- get : http://localhost:8080/entretien/read/{id}
- put : http://localhost:8080/entretien/update/{id}

body'example:
```	{
		"date": "2023-06-27",
		"hours": 5,
		"intervenant": {
			"id": "I006",
			"name": "Jean Claude",
			"taux": 10,
			"entretien": []
		},
		"materiel": {
			"id": "M003",
			"design": "Meizu M3S",
			"about": "Cam 40Mp, ROM: 16GB, RAM 3GB",
			"state": "BON",
			"entretien": []
		}
	}```
- delete : http://localhost:8080/entretien/delete/{id}
  