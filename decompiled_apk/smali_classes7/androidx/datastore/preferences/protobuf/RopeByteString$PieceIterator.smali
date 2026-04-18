.class final Landroidx/datastore/preferences/protobuf/RopeByteString$PieceIterator;
.super Ljava/lang/Object;
.source "RopeByteString.java"

# interfaces
.implements Ljava/util/Iterator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/datastore/preferences/protobuf/RopeByteString;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "PieceIterator"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Iterator<",
        "Landroidx/datastore/preferences/protobuf/ByteString$LeafByteString;",
        ">;"
    }
.end annotation


# instance fields
.field private final breadCrumbs:Ljava/util/ArrayDeque;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayDeque<",
            "Landroidx/datastore/preferences/protobuf/RopeByteString;",
            ">;"
        }
    .end annotation
.end field

.field private next:Landroidx/datastore/preferences/protobuf/ByteString$LeafByteString;


# direct methods
.method private constructor <init>(Landroidx/datastore/preferences/protobuf/ByteString;)V
    .locals 3
    .param p1, "root"    # Landroidx/datastore/preferences/protobuf/ByteString;

    .line 719
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 720
    instance-of v0, p1, Landroidx/datastore/preferences/protobuf/RopeByteString;

    if-eqz v0, :cond_0

    .line 721
    move-object v0, p1

    check-cast v0, Landroidx/datastore/preferences/protobuf/RopeByteString;

    .line 722
    .local v0, "rbs":Landroidx/datastore/preferences/protobuf/RopeByteString;
    new-instance v1, Ljava/util/ArrayDeque;

    invoke-virtual {v0}, Landroidx/datastore/preferences/protobuf/RopeByteString;->getTreeDepth()I

    move-result v2

    invoke-direct {v1, v2}, Ljava/util/ArrayDeque;-><init>(I)V

    iput-object v1, p0, Landroidx/datastore/preferences/protobuf/RopeByteString$PieceIterator;->breadCrumbs:Ljava/util/ArrayDeque;

    .line 723
    invoke-virtual {v1, v0}, Ljava/util/ArrayDeque;->push(Ljava/lang/Object;)V

    .line 724
    invoke-static {v0}, Landroidx/datastore/preferences/protobuf/RopeByteString;->access$400(Landroidx/datastore/preferences/protobuf/RopeByteString;)Landroidx/datastore/preferences/protobuf/ByteString;

    move-result-object v1

    invoke-direct {p0, v1}, Landroidx/datastore/preferences/protobuf/RopeByteString$PieceIterator;->getLeafByLeft(Landroidx/datastore/preferences/protobuf/ByteString;)Landroidx/datastore/preferences/protobuf/ByteString$LeafByteString;

    move-result-object v1

    iput-object v1, p0, Landroidx/datastore/preferences/protobuf/RopeByteString$PieceIterator;->next:Landroidx/datastore/preferences/protobuf/ByteString$LeafByteString;

    .line 725
    .end local v0    # "rbs":Landroidx/datastore/preferences/protobuf/RopeByteString;
    goto :goto_0

    .line 726
    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Landroidx/datastore/preferences/protobuf/RopeByteString$PieceIterator;->breadCrumbs:Ljava/util/ArrayDeque;

    .line 727
    move-object v0, p1

    check-cast v0, Landroidx/datastore/preferences/protobuf/ByteString$LeafByteString;

    iput-object v0, p0, Landroidx/datastore/preferences/protobuf/RopeByteString$PieceIterator;->next:Landroidx/datastore/preferences/protobuf/ByteString$LeafByteString;

    .line 729
    :goto_0
    return-void
.end method

.method synthetic constructor <init>(Landroidx/datastore/preferences/protobuf/ByteString;Landroidx/datastore/preferences/protobuf/RopeByteString$1;)V
    .locals 0
    .param p1, "x0"    # Landroidx/datastore/preferences/protobuf/ByteString;
    .param p2, "x1"    # Landroidx/datastore/preferences/protobuf/RopeByteString$1;

    .line 715
    invoke-direct {p0, p1}, Landroidx/datastore/preferences/protobuf/RopeByteString$PieceIterator;-><init>(Landroidx/datastore/preferences/protobuf/ByteString;)V

    return-void
.end method

.method private getLeafByLeft(Landroidx/datastore/preferences/protobuf/ByteString;)Landroidx/datastore/preferences/protobuf/ByteString$LeafByteString;
    .locals 3
    .param p1, "root"    # Landroidx/datastore/preferences/protobuf/ByteString;

    .line 732
    move-object v0, p1

    .line 733
    .local v0, "pos":Landroidx/datastore/preferences/protobuf/ByteString;
    :goto_0
    instance-of v1, v0, Landroidx/datastore/preferences/protobuf/RopeByteString;

    if-eqz v1, :cond_0

    .line 734
    move-object v1, v0

    check-cast v1, Landroidx/datastore/preferences/protobuf/RopeByteString;

    .line 735
    .local v1, "rbs":Landroidx/datastore/preferences/protobuf/RopeByteString;
    iget-object v2, p0, Landroidx/datastore/preferences/protobuf/RopeByteString$PieceIterator;->breadCrumbs:Ljava/util/ArrayDeque;

    invoke-virtual {v2, v1}, Ljava/util/ArrayDeque;->push(Ljava/lang/Object;)V

    .line 736
    invoke-static {v1}, Landroidx/datastore/preferences/protobuf/RopeByteString;->access$400(Landroidx/datastore/preferences/protobuf/RopeByteString;)Landroidx/datastore/preferences/protobuf/ByteString;

    move-result-object v0

    .line 737
    .end local v1    # "rbs":Landroidx/datastore/preferences/protobuf/RopeByteString;
    goto :goto_0

    .line 738
    :cond_0
    move-object v1, v0

    check-cast v1, Landroidx/datastore/preferences/protobuf/ByteString$LeafByteString;

    return-object v1
.end method

.method private getNextNonEmptyLeaf()Landroidx/datastore/preferences/protobuf/ByteString$LeafByteString;
    .locals 2

    .line 745
    nop

    :goto_0
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/RopeByteString$PieceIterator;->breadCrumbs:Ljava/util/ArrayDeque;

    if-eqz v0, :cond_2

    invoke-virtual {v0}, Ljava/util/ArrayDeque;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_1

    .line 748
    :cond_0
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/RopeByteString$PieceIterator;->breadCrumbs:Ljava/util/ArrayDeque;

    invoke-virtual {v0}, Ljava/util/ArrayDeque;->pop()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/RopeByteString;

    invoke-static {v0}, Landroidx/datastore/preferences/protobuf/RopeByteString;->access$500(Landroidx/datastore/preferences/protobuf/RopeByteString;)Landroidx/datastore/preferences/protobuf/ByteString;

    move-result-object v0

    invoke-direct {p0, v0}, Landroidx/datastore/preferences/protobuf/RopeByteString$PieceIterator;->getLeafByLeft(Landroidx/datastore/preferences/protobuf/ByteString;)Landroidx/datastore/preferences/protobuf/ByteString$LeafByteString;

    move-result-object v0

    .line 749
    .local v0, "result":Landroidx/datastore/preferences/protobuf/ByteString$LeafByteString;
    invoke-virtual {v0}, Landroidx/datastore/preferences/protobuf/ByteString$LeafByteString;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_1

    .line 750
    return-object v0

    .line 752
    .end local v0    # "result":Landroidx/datastore/preferences/protobuf/ByteString$LeafByteString;
    :cond_1
    goto :goto_0

    .line 746
    :cond_2
    :goto_1
    const/4 v0, 0x0

    return-object v0
.end method


# virtual methods
.method public hasNext()Z
    .locals 1

    .line 758
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/RopeByteString$PieceIterator;->next:Landroidx/datastore/preferences/protobuf/ByteString$LeafByteString;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public next()Landroidx/datastore/preferences/protobuf/ByteString$LeafByteString;
    .locals 2

    .line 768
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/RopeByteString$PieceIterator;->next:Landroidx/datastore/preferences/protobuf/ByteString$LeafByteString;

    if-eqz v0, :cond_0

    .line 771
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/RopeByteString$PieceIterator;->next:Landroidx/datastore/preferences/protobuf/ByteString$LeafByteString;

    .line 772
    .local v0, "result":Landroidx/datastore/preferences/protobuf/ByteString$LeafByteString;
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/RopeByteString$PieceIterator;->getNextNonEmptyLeaf()Landroidx/datastore/preferences/protobuf/ByteString$LeafByteString;

    move-result-object v1

    iput-object v1, p0, Landroidx/datastore/preferences/protobuf/RopeByteString$PieceIterator;->next:Landroidx/datastore/preferences/protobuf/ByteString$LeafByteString;

    .line 773
    return-object v0

    .line 769
    .end local v0    # "result":Landroidx/datastore/preferences/protobuf/ByteString$LeafByteString;
    :cond_0
    new-instance v0, Ljava/util/NoSuchElementException;

    invoke-direct {v0}, Ljava/util/NoSuchElementException;-><init>()V

    throw v0
.end method

.method public bridge synthetic next()Ljava/lang/Object;
    .locals 1

    .line 715
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/RopeByteString$PieceIterator;->next()Landroidx/datastore/preferences/protobuf/ByteString$LeafByteString;

    move-result-object v0

    return-object v0
.end method

.method public remove()V
    .locals 1

    .line 778
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method
