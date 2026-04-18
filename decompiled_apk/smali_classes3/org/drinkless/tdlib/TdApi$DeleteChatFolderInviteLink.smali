.class public Lorg/drinkless/tdlib/TdApi$DeleteChatFolderInviteLink;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DeleteChatFolderInviteLink"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x376f8e82


# instance fields
.field public chatFolderId:I

.field public inviteLink:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 25004
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25005
    return-void
.end method

.method public constructor <init>(ILjava/lang/String;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "str"    # Ljava/lang/String;

    .line 24994
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 24995
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$DeleteChatFolderInviteLink;->chatFolderId:I

    .line 24996
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$DeleteChatFolderInviteLink;->inviteLink:Ljava/lang/String;

    .line 24997
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 25001
    const v0, -0x376f8e82

    return v0
.end method
