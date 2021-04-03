This directory is where you'll write all of your code!

By default it contains a barebones portfolio web app. To run a local server,
execute this command:

```
mvn package exec:java
```

## Datastore emulator
Run the following guide to set up the Datastore emulator:

```bash
teachme ~/spring21-sps-26/datastore-emulator.md
```

## API documentation

### Guides: list
Retrieves a list of guides.

#### Request

##### Http request

| Method | Endpoint |
| --- | --- |
| `GET` | `/guides` |

##### Parameters
There are not any parameters for this method at the moment.

##### Request Body
No need to provide a body with this method.

#### Response

If the request succeeds, the server responds with an HTTP `200 OK`.

##### Response Body
The body of the response contains a list with the existing guides.
```JSON
[
    {
        "id": number,
        "timestamp": number,
        "title": string,
        "description": string, 
        "content": string
    },
    ...
]
```

### Guides: insert
Adds a guide.

#### Request

##### Http request

| Method | Endpoint |
| --- | --- |
| `POST` | `/guides` |

##### Parameters
| Parameter Name | Value | Description |
| --- | --- | --- |
| **Required parameters** |
| title | string | Title of the new guide. |
| description | string | Description of the new guide. |
| content | string | Content of the new guide. |

##### Request Body
No need to provide a body with this method.

#### Response

If the request succeeds, the server responds with an HTTP `201 Created`.

##### Response Body
The body of the response contains the guide that was just added.
```JSON
{
    "id": number,
    "timestamp": number,
    "title": string,
    "description": string, 
    "content": string
}
```

### Guides: get
Gets a guide.

#### Request

##### Http request

| Method | Endpoint |
| --- | --- |
| `GET` | `/guides/{guideId}` |

##### Parameters
There are not any parameters for this method at the moment.

##### Request Body
No need to provide a body with this method.

#### Response

If the request succeeds, the server responds with an HTTP `200 OK`. 

##### Response Body
The body of the response contains the guide requested.
```JSON
{
    "id": number,
    "timestamp": number,
    "title": string,
    "description": string, 
    "content": string
}
```