.class public Lorg/drinkless/tdlib/TdApi$ToggleSessionCanAcceptSecretChats;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ToggleSessionCanAcceptSecretChats"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3ba7a87e


# instance fields
.field public canAcceptSecretChats:Z

.field public sessionId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 33368
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33369
    return-void
.end method

.method public constructor <init>(JZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z

    .line 33358
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33359
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ToggleSessionCanAcceptSecretChats;->sessionId:J

    .line 33360
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$ToggleSessionCanAcceptSecretChats;->canAcceptSecretChats:Z

    .line 33361
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 33365
    const v0, 0x3ba7a87e

    return v0
.end method
