.class public Lorg/drinkless/tdlib/TdApi$EditChatFolderInviteLink;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EditChatFolderInviteLink"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$ChatFolderInviteLink;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7faa5fdf


# instance fields
.field public chatFolderId:I

.field public chatIds:[J

.field public inviteLink:Ljava/lang/String;

.field public name:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 43110
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 43111
    return-void
.end method

.method public constructor <init>(ILjava/lang/String;Ljava/lang/String;[J)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "str2"    # Ljava/lang/String;
    .param p4, "jArr"    # [J

    .line 43098
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 43099
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$EditChatFolderInviteLink;->chatFolderId:I

    .line 43100
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$EditChatFolderInviteLink;->inviteLink:Ljava/lang/String;

    .line 43101
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$EditChatFolderInviteLink;->name:Ljava/lang/String;

    .line 43102
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$EditChatFolderInviteLink;->chatIds:[J

    .line 43103
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 43107
    const v0, -0x7faa5fdf

    return v0
.end method
