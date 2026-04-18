.class public Lorg/drinkless/tdlib/TdApi$CallStateError;
.super Lorg/drinkless/tdlib/TdApi$CallState;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CallStateError"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3a209b6b


# instance fields
.field public error:Lorg/drinkless/tdlib/TdApi$Error;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9294
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$CallState;-><init>()V

    .line 9295
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Error;)V
    .locals 0
    .param p1, "error"    # Lorg/drinkless/tdlib/TdApi$Error;

    .line 9285
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$CallState;-><init>()V

    .line 9286
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$CallStateError;->error:Lorg/drinkless/tdlib/TdApi$Error;

    .line 9287
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9291
    const v0, -0x3a209b6b

    return v0
.end method
