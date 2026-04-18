.class public Lorg/drinkless/tdlib/TdApi$StartScheduledVideoChat;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StartScheduledVideoChat"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4d89167e


# instance fields
.field public groupCallId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20220
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 20221
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 20211
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 20212
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$StartScheduledVideoChat;->groupCallId:I

    .line 20213
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 20217
    const v0, -0x4d89167e

    return v0
.end method
