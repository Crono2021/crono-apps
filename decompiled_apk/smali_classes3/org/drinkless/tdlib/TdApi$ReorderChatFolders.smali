.class public Lorg/drinkless/tdlib/TdApi$ReorderChatFolders;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ReorderChatFolders"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6342745a


# instance fields
.field public chatFolderIds:[I

.field public mainChatListPosition:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 30048
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30049
    return-void
.end method

.method public constructor <init>([II)V
    .locals 0
    .param p1, "iArr"    # [I
    .param p2, "i9"    # I

    .line 30038
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30039
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ReorderChatFolders;->chatFolderIds:[I

    .line 30040
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$ReorderChatFolders;->mainChatListPosition:I

    .line 30041
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 30045
    const v0, 0x6342745a

    return v0
.end method
