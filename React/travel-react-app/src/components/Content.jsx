import React from 'react'

function Content(props) {
  return (
    <div>
        {props.card.map((element, index) =>
            <div className='box' key={index}>
                <div className='place'>
                    <img src={element.url} className="pic"></img>
                    <div className='list'>
                        <div className='country'>
                            <img src='/src/assets/geo-alt-fill.svg' className='locationicon'></img>
                            <p className='countryname'>{element.country}</p>
                            <a><p className='maps'>View on Google maps</p></a>
                        </div>
                        <div className='des'>
                            <p className='heading1'>{element.place}</p>
                            <h1 className='placename'></h1>
                            <p className='date'>{element.date}</p>
                            <p className='description'>{element.desc}</p>
                        </div>
                    </div>
                </div>
            </div>
        )}
    </div>
  )
}

export default Content