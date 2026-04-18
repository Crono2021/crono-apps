.class public Lorg/drinkless/tdlib/TdApi$CreateChatFolderInviteLink;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CreateChatFolderInviteLink"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$ChatFolderInviteLink;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x79780e3b


# instance fields
.field public chatFolderId:I

.field public chatIds:[J

.field public name:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 36410
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 36411
    return-void
.end method

.method public constructor <init>(ILjava/lang/String;[J)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "jArr"    # [J

    .line 36399
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 36400
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$CreateChatFolderInviteLink;->chatFolderId:I

    .line 36401
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$CreateChatFolderInviteLink;->name:Ljava/lang/String;

    .line 36402
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$CreateChatFolderInviteLink;->chatIds:[J

    .line 36403
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 36407
    const v0, -0x79780e3b

    return v0
.end method
