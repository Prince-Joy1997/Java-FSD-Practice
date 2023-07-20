import React from 'react'
import MarkList from './MarkList'


const marks = [
    { name: 'John Doe', age: 17, marks: 'B' },
    { name: 'Jane Doe', age: 17, marks: 'A' },
    { name: 'TomCat', age: 26, marks: 'A+' }
]


function MarkRoot() {
  return (
    <MarkList list = {marks}/>
  )
}

export default MarkRoot