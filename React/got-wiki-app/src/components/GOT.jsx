import React, { useState, useEffect } from 'react'
import axios from 'axios'

function GOT() {

    const [wikia, setWikia] = useState([])
    // const [index, setIndex] = useState(0)

    useEffect(() => {
        axios.get('https://thronesapi.com/api/v2/Characters/')
            .then(response => {
                if (response.status === 200) {
                    setWikia(response.data)
                    { console.log(wikia) }
                }
            })
            .catch(error => console.error(error))
    }, [])

    // const next = () => {
    //     setIndex(prevIndex => prevIndex + 1)
    // }

    return (
        // <div className="card mb-3" >
        //     <div className="row g-0">
        //         <div className="col-md-4">
        //             <img src={wikia.imageUrl} className="img-fluid rounded-start" alt="image" />
        //         </div>
        //         <div className="col-md-4">
        //             <div className="card-body">
        //                 <h5 className="card-title">{wikia.fullName}</h5>
        //                 <p className="card-text">
        //                     <small className="text-body-secondary">Last updated 3 mins ago</small>
        //                 </p>
        //                 <p>
        //                     <button className="btn btn-lg btn-primary" onClick={next}>Next Character</button>
        //                 </p>
        //             </div>
        //         </div>
        //     </div>
        // </div>

        <table className="table">
            <thead>
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">Name</th>
                    <th scope="col">Image</th>
                </tr>
            </thead>
            <tbody>
                {wikia.map(wikis => (
                    <tr>
                        <td>{wikis.id}</td>
                        <td>{wikis.fullName}</td>
                        <td><img src={wikis.imageUrl} className="img-fluid rounded"
                            style={{ maxWidth: '100px' }} alt="image"></img></td>
                    </tr>))}
            </tbody>
        </table>
    )
}
export default GOT