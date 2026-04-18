.class public Lorg/drinkless/tdlib/TdApi$CreateSupergroupChat;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CreateSupergroupChat"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Chat;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x46c770eb


# instance fields
.field public force:Z

.field public supergroupId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 24724
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 24725
    return-void
.end method

.method public constructor <init>(JZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z

    .line 24714
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 24715
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$CreateSupergroupChat;->supergroupId:J

    .line 24716
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$CreateSupergroupChat;->force:Z

    .line 24717
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 24721
    const v0, 0x46c770eb

    return v0
.end method
