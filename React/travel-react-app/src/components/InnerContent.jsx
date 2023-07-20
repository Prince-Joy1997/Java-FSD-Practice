import React from 'react'
import Content from './content'

function InnerContent() {
    const array = [
        {url:'/src/assets/japan.jpg',country:'JAPAN',place:'Mount Fuji',date:'12 Jan,2021-24 Jan,2021',desc:'Mount fuji is the tallest mountain in japan'},
        {url:'src/assets/australia.jpg',country:'AUSTRALIA',place:'Sydney Opera House',date:'27 May,2021-8 Jun,2021',desc:'The Suydney Opera House is a multi-venue performing arts centre in the Sydney'},
        {url:'src/assets/norway.jpg',country:'NORWAY',place:'Geirangerfjord',date:'01 Oct,2021-18 Nov,2021',desc:'The Geirangerfjord is a fjord in the Sunnmore region of More og Romsdal,Norway'}
    ]
  return (
    <div>
        <Content card = {array}/>
    </div>
  )
}

export default InnerContent