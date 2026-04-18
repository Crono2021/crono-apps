.class public Lorg/drinkless/tdlib/TdApi$Background;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Background"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x19a0d6e4


# instance fields
.field public document:Lorg/drinkless/tdlib/TdApi$Document;

.field public id:J

.field public isDark:Z

.field public isDefault:Z

.field public name:Ljava/lang/String;

.field public type:Lorg/drinkless/tdlib/TdApi$BackgroundType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 49422
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 49423
    return-void
.end method

.method public constructor <init>(JZZLjava/lang/String;Lorg/drinkless/tdlib/TdApi$Document;Lorg/drinkless/tdlib/TdApi$BackgroundType;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z
    .param p4, "z9"    # Z
    .param p5, "str"    # Ljava/lang/String;
    .param p6, "document"    # Lorg/drinkless/tdlib/TdApi$Document;
    .param p7, "backgroundType"    # Lorg/drinkless/tdlib/TdApi$BackgroundType;

    .line 49408
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 49409
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$Background;->id:J

    .line 49410
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$Background;->isDefault:Z

    .line 49411
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$Background;->isDark:Z

    .line 49412
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$Background;->name:Ljava/lang/String;

    .line 49413
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$Background;->document:Lorg/drinkless/tdlib/TdApi$Document;

    .line 49414
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$Background;->type:Lorg/drinkless/tdlib/TdApi$BackgroundType;

    .line 49415
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 49419
    const v0, -0x19a0d6e4

    return v0
.end method
