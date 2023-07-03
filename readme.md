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
- get http://localhost:8080/materiel/search/chaine/{chaine}

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
- get : http://localhost:8080/intervenant/search/chaine/{chaine}  
	- chaine = chaine à chercher
  
  requestBody :
    ```
        {
            "name": "Peter JackSon",
            "taux": 10
        }
	```

- delete : http://localhost:8080/intervenant/delete/{id}


## ENTRETIEN
- lister les entretien(get) : http://localhost:8080/entretien/read
- delete : http://localhost:8080/entretien/delete/{id}
- create (post) : http://localhost:8080/entretien/create
	body : 
	```
		{
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
	}
	```

- lecture en detail(get) : http://localhost:8080/entretien/read/{id}

- update(put): http://localhost:8080/entretien/update/{id}
  
  	body : 
	```
		{
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
	}
	```

- get : http://localhost:8080/entretien/search/{month}
	month = en entier(exemple: mois de janvier = 1)

- get : http://localhost:8080/entretien/search/{date_debut}/{dateFin}  : recherche entre deux date
  