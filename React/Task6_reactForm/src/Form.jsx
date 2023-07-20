import React from 'react'
import './Form.css'

function Form() {
  const [formData,setFormData] = React.useState({
    'firstname' : 'Firstname',
    'Lastname' : 'Lastname',
    'Username' : 'Username',
    'City' : 'City',
    'State' : '',
    'Zip' : 'ZipCode'
}
)
function ValueChange(event) {
    const{name,value,type,checked} = event.target
    setFormData(prevFormData =>{
        return{
            ...prevFormData,
            [name]:[value]
        }
    })
}
function submit(){
    alert(formData.firstname+' '+formData.Lastname+' '+formData.Username+' '+formData.City+' '+formData.State+' '+formData.Zip)
}
return (
<>
<form class="row gx-3 gy-2 align-items-center main">
<div class="col-sm-4">
<label>First name</label>
<input type="text" class="form-control" name='firstname' placeholder={formData.firstname} onChange={ValueChange}/>
</div>
<div class="col-sm-4">
<label>Last name</label>
<input type="text" class="form-control" name='Lastname' placeholder={formData.Lastname} onChange={ValueChange}/>
</div>
<div class="col-sm-4">
<label>Username</label>
<div class="input-group">
  <div class="input-group-text">@</div>
  <input type="text" class="form-control" id="specificSizeInputGroupUsername"  name='Username' placeholder={formData.Username} onChange={ValueChange}/>
</div>
</div>
<div class="col-sm-4">
<label>City</label>
<input type="text" class="form-control" id="specificSizeInputName" name='City' placeholder={formData.City} onChange={ValueChange}/>
</div>
<div class="col-sm-4">
<label>State</label>
<select class="form-select" id="specificSizeSelect" name='State' placeholder={formData.State} onChange={ValueChange}>
  <option value="Choose">Choose...</option>
  <option value="Kerala">Kerala</option>
  <option value="Tamilnadu">Tamilnadu</option>
  <option value="Karanataka">Karanataka</option>
</select>
</div>
<div class="col-sm-4">
<label>Zip</label>
<input type="text" class="form-control" id="specificSizeInputName" name='Zip' placeholder={formData.Zip} onChange={ValueChange}/>
</div>
<div class="col-auto">
<button type="submit" class="btn btn-primary" onClick={submit}>Submit Form</button>
</div>
</form>
</>
)
}

export default Form