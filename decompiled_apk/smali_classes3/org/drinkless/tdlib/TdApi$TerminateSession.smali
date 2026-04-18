.class public Lorg/drinkless/tdlib/TdApi$TerminateSession;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TerminateSession"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x184836d4


# instance fields
.field public sessionId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20886
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 20887
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 20877
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 20878
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$TerminateSession;->sessionId:J

    .line 20879
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 20883
    const v0, -0x184836d4

    return v0
.end method
