.class public Lorg/drinkless/tdlib/TdApi$SearchMessages;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SearchMessages"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$FoundMessages;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x490addb5


# instance fields
.field public chatList:Lorg/drinkless/tdlib/TdApi$ChatList;

.field public chatTypeFilter:Lorg/drinkless/tdlib/TdApi$SearchMessagesChatTypeFilter;

.field public filter:Lorg/drinkless/tdlib/TdApi$SearchMessagesFilter;

.field public limit:I

.field public maxDate:I

.field public minDate:I

.field public offset:Ljava/lang/String;

.field public query:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 52268
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 52269
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ChatList;Ljava/lang/String;Ljava/lang/String;ILorg/drinkless/tdlib/TdApi$SearchMessagesFilter;Lorg/drinkless/tdlib/TdApi$SearchMessagesChatTypeFilter;II)V
    .locals 0
    .param p1, "chatList"    # Lorg/drinkless/tdlib/TdApi$ChatList;
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "str2"    # Ljava/lang/String;
    .param p4, "i9"    # I
    .param p5, "searchMessagesFilter"    # Lorg/drinkless/tdlib/TdApi$SearchMessagesFilter;
    .param p6, "searchMessagesChatTypeFilter"    # Lorg/drinkless/tdlib/TdApi$SearchMessagesChatTypeFilter;
    .param p7, "i10"    # I
    .param p8, "i11"    # I

    .line 52252
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 52253
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SearchMessages;->chatList:Lorg/drinkless/tdlib/TdApi$ChatList;

    .line 52254
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SearchMessages;->query:Ljava/lang/String;

    .line 52255
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SearchMessages;->offset:Ljava/lang/String;

    .line 52256
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$SearchMessages;->limit:I

    .line 52257
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$SearchMessages;->filter:Lorg/drinkless/tdlib/TdApi$SearchMessagesFilter;

    .line 52258
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$SearchMessages;->chatTypeFilter:Lorg/drinkless/tdlib/TdApi$SearchMessagesChatTypeFilter;

    .line 52259
    iput p7, p0, Lorg/drinkless/tdlib/TdApi$SearchMessages;->minDate:I

    .line 52260
    iput p8, p0, Lorg/drinkless/tdlib/TdApi$SearchMessages;->maxDate:I

    .line 52261
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 52265
    const v0, 0x490addb5

    return v0
.end method
