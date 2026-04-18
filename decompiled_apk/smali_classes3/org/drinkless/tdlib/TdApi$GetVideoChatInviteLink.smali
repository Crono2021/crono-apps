.class public Lorg/drinkless/tdlib/TdApi$GetVideoChatInviteLink;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetVideoChatInviteLink"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$HttpUrl;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x53218b79


# instance fields
.field public canSelfUnmute:Z

.field public groupCallId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 26824
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26825
    return-void
.end method

.method public constructor <init>(IZ)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "z8"    # Z

    .line 26814
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26815
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$GetVideoChatInviteLink;->groupCallId:I

    .line 26816
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$GetVideoChatInviteLink;->canSelfUnmute:Z

    .line 26817
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 26821
    const v0, -0x53218b79

    return v0
.end method
