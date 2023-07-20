import React from 'react'
import './RoomAvailability.css'
import { useState } from 'react'


function RoomAvailability() {

    const [roomlist, setroomlist] = useState([
        { num: 1, type: 'Gold', status: 'Free' },
        { num: 2, type: 'Gold', status: 'Booked' },
        { num: 3, type: 'Gold', status: 'Free' },
        { num: 4, type: 'Gold', status: 'Booked' },
        { num: 5, type: 'Gold', status: 'Free' },
        { num: 6, type: 'Platinum', status: 'Booked' },
        { num: 7, type: 'Platinum', status: 'Booked' },
        { num: 8, type: 'Platinum', status: 'Free' },
        { num: 9, type: 'Platinum', status: 'Booked' },
        { num: 10, type: 'Platinum', status: 'Free' },
        { num: 11, type: 'Diamond', status: 'Free' },
        { num: 12, type: 'Diamond', status: 'Free' },
        { num: 13, type: 'Diamond', status: 'Free' },
        { num: 14, type: 'Diamond', status: 'Free' },
        { num: 15, type: 'Diamond', status: 'Booked' }
    ])

    const StatusChange = (roomNum) => {
        setroomlist(Room => Room.map(room => {
            if (room.num === roomNum) {
                return Object.assign({}, room, { status: room.status === 'Free' ? 'Booked' : 'Free' });
            }
            return room;
        }));
    };

    function groupByType() {
        const groupedRooms = {}

        for (const room of roomlist) {
            if (!groupedRooms.hasOwnProperty(room.type)) {
                groupedRooms[room.type] = []
            }
            groupedRooms[room.type].push(room)
        }
        return groupedRooms
    }

    const groupedRooms = groupByType();

    return (
        <div className='content'>
            {Object.entries(groupedRooms).map(([type, typeRooms]) => (
                <div className='title' key={type}>
                    <h1>{type}</h1>
                    <div className='block'>
                        {typeRooms.map(room => (
                            <div key={room.num}>
                                <button
                                    style={{ backgroundColor: room.status === 'Booked' ? 'rgb(33,53,71)' : 'white' }} onClick={() => StatusChange(room.num)}
                                    className='btn'>
                                    {room.num}
                                </button>
                            </div>
                        ))}
                    </div>
                </div>
            ))}
        </div>
    )
}

export default RoomAvailability