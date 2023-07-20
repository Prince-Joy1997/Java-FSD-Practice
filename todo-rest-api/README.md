# ToDo Application

Properties of a ToDo

```
    id: number,
    reminder: string,
    status: boolean
```

```json
{
    "id": 1,
    "reminder": "Buy Milk",
    "status": false
}
```

```java
class ToDo{
    
    private int id;
    private String reminder;
    private boolean status;
    
    public ToDo(){
        
    }
    
    public ToDo(int id, String reminder, boolean status){
        this.id = id;
        this.reminder = reminder;
        this.status = status;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getReminder(){
        return reminder;
    }
    
    public void setReminder(String reminder){
        this.reminder = reminder;
    }
    
    public boolean getStatus(){
        return status;
    }
    
    public void setStatus(boolean status){
        this.status = status;
    }
    
    @Override
    public String toString(){
        return "ToDo [id=" + id + ", reminder=" + reminder + ", status=" + status + "]";
    }
}   
```

## API

### Get all ToDo

```
    GET /api/v1/todos
```

### Get a ToDo

```
    GET /api/v1/todos/{id}
```

### Create a ToDo

```
    POST /api/v1/todos
```

### Update a ToDo

```
    PUT /api/v1/todos/{id}
```

### Delete a ToDo

```
    DELETE /api/v1/todos/{id}
```