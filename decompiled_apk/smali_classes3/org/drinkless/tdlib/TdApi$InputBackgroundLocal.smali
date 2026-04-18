.class public Lorg/drinkless/tdlib/TdApi$InputBackgroundLocal;
.super Lorg/drinkless/tdlib/TdApi$InputBackground;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputBackgroundLocal"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x68228b5c


# instance fields
.field public background:Lorg/drinkless/tdlib/TdApi$InputFile;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 14424
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputBackground;-><init>()V

    .line 14425
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InputFile;)V
    .locals 0
    .param p1, "inputFile"    # Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 14415
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputBackground;-><init>()V

    .line 14416
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputBackgroundLocal;->background:Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 14417
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 14421
    const v0, -0x68228b5c

    return v0
.end method
