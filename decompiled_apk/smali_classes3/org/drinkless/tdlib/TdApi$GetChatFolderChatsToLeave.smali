.class public Lorg/drinkless/tdlib/TdApi$GetChatFolderChatsToLeave;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetChatFolderChatsToLeave"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Chats;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x723e1951


# instance fields
.field public chatFolderId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 12426
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12427
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 12417
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12418
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$GetChatFolderChatsToLeave;->chatFolderId:I

    .line 12419
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 12423
    const v0, -0x723e1951

    return v0
.end method
