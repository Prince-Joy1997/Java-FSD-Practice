import React from 'react'
import Login from './components/Login';
import { ThemeContext } from './components/ThemeContext';

function App() {

  const [textColor, setTextColor] = React.useState('light')
  const [bgColor, setBgColor] = React.useState('dark')

  return (
    <ThemeContext.Provider value = {{textColor, setTextColor,bgColor, setBgColor}}>
      <Login />
    </ThemeContext.Provider>
  );
}

export default App