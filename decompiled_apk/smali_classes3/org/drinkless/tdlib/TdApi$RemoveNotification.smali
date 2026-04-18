.class public Lorg/drinkless/tdlib/TdApi$RemoveNotification;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RemoveNotification"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x336ab34e


# instance fields
.field public notificationGroupId:I

.field public notificationId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29928
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 29929
    return-void
.end method

.method public constructor <init>(II)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "i10"    # I

    .line 29918
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 29919
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$RemoveNotification;->notificationGroupId:I

    .line 29920
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$RemoveNotification;->notificationId:I

    .line 29921
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29925
    const v0, 0x336ab34e

    return v0
.end method
