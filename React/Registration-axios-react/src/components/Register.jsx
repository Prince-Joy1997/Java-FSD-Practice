import axios from 'axios'
import React, { useState } from 'react'
import Notification from './Notification'
import RegisterForm from './RegisterForm'

const Register = () => {

    const [registerFormData, setRegisterFormData] = useState({
        fullName: '', email: '', password: '', accepted: false
      })
    
      const [userCreated, setUserCreated] = useState(false)

      function register(event){
          event.target.disabled = true
          const payload = {
              fullName: registerFormData.fullName,
              email: registerFormData.email,
              password: registerFormData.password
          }

          axios.post('http://localhost:3000/user',payload)
                    .then(response =>{
                        console.log(response.status)
                        if(response.status === 201){
                            setUserCreated(true)
                        }
                    })
                    .catch(err =>{
                        setUserCreated(false)
                        console.error(err)
                    })
      }


      function inputChange(event){
          const {name, value, type, checked} = event.target
          setRegisterFormData(prevState => {
              return{
                  ...prevState,
                  [name]: type === 'checkbox' ? checked : value
              }
          })

          console.log(registerFormData)
      }

  return (
    <div>
        {
        !userCreated ?
          <RegisterForm data={registerFormData} change={inputChange} click={register}></RegisterForm> :
          <Notification status={userCreated}></Notification>
        }
    </div>

  )
}

export default Register