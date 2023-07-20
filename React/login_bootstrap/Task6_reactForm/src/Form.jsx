import React from 'react'
import './Form.css'

function Form() {
    const [firstName, setFirstName] = React.useState('firstName');
    const [lastName, setLastName] = React.useState('lastName');
    const [username, setUsername] = React.useState('username');
    const [city, setCity] = React.useState('city');
    const [state, setState] = React.useState('state');
    const [zipCode, setZipCode] = React.useState('zipCode');
  
    const handleSubmit = (e) => {
      e.preventDefault();
  
    };
  
    return (
      <div>
        <h1>Registration Form</h1>
  
        <form onSubmit={handleSubmit}>
          <label htmlFor="firstName">First Name:</label>
          <input
            type="text"
            id="firstName"
            value={firstName}
            onChange={(e) => setFirstName(e.target.value)}
            required
          /><br />
  
          <label htmlFor="lastName">Last Name:</label>
          <input
            type="text"
            id="lastName"
            value={lastName}
            onChange={(e) => setLastName(e.target.value)}
            required
          /><br />
  
          <label htmlFor="username">Username:</label>
          <input
            type="text"
            id="username"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            required
          /><br />
  
          <label htmlFor="city">City:</label>
          <input
            type="text"
            id="city"
            value={city}
            onChange={(e) => setCity(e.target.value)}
            required
          /><br />
  
          <label htmlFor="state">State:</label>
          <select
            id="state"
            value={state}
            onChange={(e) => setState(e.target.value)}
            required
          >
            <option value="">-- Select State --</option>
            <option value="AL">Kerala</option>
            <option value="AK">Tamilnadu</option>
            <option value="AZ">Karnataka</option>
          </select><br/>
  
          <label htmlFor="zipCode">Zip Code:</label>
          <input
            type="text"
            id="zipCode"
            value={zipCode}
            onChange={(e) => setZipCode(e.target.value)}
            required
          /><br />
          <input type="submit" value="Submit" />
        </form>
      </div>
    );
}

export default Form