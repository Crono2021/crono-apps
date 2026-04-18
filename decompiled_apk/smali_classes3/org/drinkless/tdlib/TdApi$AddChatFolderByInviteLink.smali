.class public Lorg/drinkless/tdlib/TdApi$AddChatFolderByInviteLink;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AddChatFolderByInviteLink"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x332d1a18


# instance fields
.field public chatIds:[J

.field public inviteLink:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22704
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 22705
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;[J)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "jArr"    # [J

    .line 22694
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 22695
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$AddChatFolderByInviteLink;->inviteLink:Ljava/lang/String;

    .line 22696
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$AddChatFolderByInviteLink;->chatIds:[J

    .line 22697
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 22701
    const v0, -0x332d1a18

    return v0
.end method
