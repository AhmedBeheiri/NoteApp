//
//  NoteListViewModel.swift
//  iosApp
//
//  Created by Ahmed Beheiri on 07/10/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import shared
import SwiftUI
import CloudKit

extension NoteListScreen{
    @MainActor class NoteListViewModel : ObservableObject{
        private var noteDataSource:NoteDataSource? = nil
        private let searchNotes = SearchNotes()
        private var notes = [Note]()
        @Published private(set) var filterNotes = [Note]()
        @Published var searchText = ""{
            didSet{
                self.filterNotes = searchNotes.execute(notes: self.notes, query: searchText)
            }
        }
        @Published private(set) var isSearchActive = false
        init(noteDataSource:NoteDataSource? = nil){
            self.noteDataSource = noteDataSource
        }
        func setNoteDataSource(noteDataSource:NoteDataSource){
            self.noteDataSource = noteDataSource
          
        }
        func loadNotes(){
            noteDataSource?.getAllNotes(completionHandler: { notes, error in
                self.notes = notes ?? []
                self.filterNotes = self.notes
            })
        }
        func deleteNoteById(id:Int64?){
           
            noteDataSource?.deleteNoteById(id: id!, completionHandler: { error in
                self.loadNotes()
            })
            
        }
        
        func toggleIsSearchActive(){
            isSearchActive = !isSearchActive
            if !isSearchActive{
                searchText = ""
            }
        }
        
    }
}
