.class public Lorg/drinkless/tdlib/TdApi$BackgroundTypeFill;
.super Lorg/drinkless/tdlib/TdApi$BackgroundType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BackgroundTypeFill"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3b301c2c


# instance fields
.field public fill:Lorg/drinkless/tdlib/TdApi$BackgroundFill;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9078
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$BackgroundType;-><init>()V

    .line 9079
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$BackgroundFill;)V
    .locals 0
    .param p1, "backgroundFill"    # Lorg/drinkless/tdlib/TdApi$BackgroundFill;

    .line 9069
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$BackgroundType;-><init>()V

    .line 9070
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$BackgroundTypeFill;->fill:Lorg/drinkless/tdlib/TdApi$BackgroundFill;

    .line 9071
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9075
    const v0, 0x3b301c2c

    return v0
.end method
