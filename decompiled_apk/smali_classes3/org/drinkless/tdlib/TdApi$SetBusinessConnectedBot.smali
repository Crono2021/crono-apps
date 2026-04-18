.class public Lorg/drinkless/tdlib/TdApi$SetBusinessConnectedBot;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetBusinessConnectedBot"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x530e8110


# instance fields
.field public bot:Lorg/drinkless/tdlib/TdApi$BusinessConnectedBot;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19500
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19501
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$BusinessConnectedBot;)V
    .locals 0
    .param p1, "businessConnectedBot"    # Lorg/drinkless/tdlib/TdApi$BusinessConnectedBot;

    .line 19491
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19492
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetBusinessConnectedBot;->bot:Lorg/drinkless/tdlib/TdApi$BusinessConnectedBot;

    .line 19493
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 19497
    const v0, -0x530e8110

    return v0
.end method
