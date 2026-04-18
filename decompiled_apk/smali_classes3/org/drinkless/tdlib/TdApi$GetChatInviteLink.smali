.class public Lorg/drinkless/tdlib/TdApi$GetChatInviteLink;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetChatInviteLink"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$ChatInviteLink;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1c95be03


# instance fields
.field public chatId:J

.field public inviteLink:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 25804
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25805
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;

    .line 25794
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25795
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetChatInviteLink;->chatId:J

    .line 25796
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$GetChatInviteLink;->inviteLink:Ljava/lang/String;

    .line 25797
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 25801
    const v0, -0x1c95be03

    return v0
.end method
