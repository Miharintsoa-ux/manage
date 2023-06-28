## Materiel
- http://localhost:8080/materiel/create

body's example:
```
    {
        "id": "M003",
        "design": "Meizu M3S",
        "about": "Cam 40Mp, ROM: 16GB, RAM 3GB",
        "state": "BON"
    }
```
- http://localhost:8080/materiel/read
- http://localhost:8080/materiel/read/{id}
- http://localhost:8080/materiel/update/{id}

body's example:
```
    {
        "design": "Meizu M3S",
        "about": "Cam 40Mp, ROM: 16GB, RAM 3GB",
        "state": "BON"
    }
```
- http://localhost:8080/materiel/delete/{id}
- http://localhost:8080/materiel/state

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
- http://localhost:8080/intervenant/create
  
  requestBody :
    ```
        {
            "id": "I001"
            "name": "Peter Parker",
            "taux": 10
        }
    ```
- http://localhost:8080/intervenant/read
- http://localhost:8080/intervenant/read/{id}
- http://localhost:8080/intervenant/update/{id}
  
  requestBody :
    ```
        {
            "name": "Peter JackSon",
            "taux": 10
        }
```
- http://localhost:8080/intervenant/delete/{id}
  
## Entretien
- http://localhost:8080/entretien/create
  
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
- http://localhost:8080/entretien/read
- http://localhost:8080/entretien/read/{id}
- http://localhost:8080/entretien/update/{id}

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
- http://localhost:8080/entretien/delete/{id}
  