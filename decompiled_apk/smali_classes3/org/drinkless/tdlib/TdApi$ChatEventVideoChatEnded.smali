.class public Lorg/drinkless/tdlib/TdApi$ChatEventVideoChatEnded;
.super Lorg/drinkless/tdlib/TdApi$ChatEventAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatEventVideoChatEnded"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x61286c48


# instance fields
.field public groupCallId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 10104
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 10105
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 10095
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 10096
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ChatEventVideoChatEnded;->groupCallId:I

    .line 10097
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 10101
    const v0, 0x61286c48

    return v0
.end method
