.class public Lorg/drinkless/tdlib/TdApi$MessageEffect;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageEffect"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x68d5b6d1


# instance fields
.field public emoji:Ljava/lang/String;

.field public id:J

.field public isPremium:Z

.field public staticIcon:Lorg/drinkless/tdlib/TdApi$Sticker;

.field public type:Lorg/drinkless/tdlib/TdApi$MessageEffectType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 48060
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 48061
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$Sticker;Ljava/lang/String;ZLorg/drinkless/tdlib/TdApi$MessageEffectType;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "sticker"    # Lorg/drinkless/tdlib/TdApi$Sticker;
    .param p4, "str"    # Ljava/lang/String;
    .param p5, "z8"    # Z
    .param p6, "messageEffectType"    # Lorg/drinkless/tdlib/TdApi$MessageEffectType;

    .line 48047
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 48048
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$MessageEffect;->id:J

    .line 48049
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$MessageEffect;->staticIcon:Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 48050
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$MessageEffect;->emoji:Ljava/lang/String;

    .line 48051
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$MessageEffect;->isPremium:Z

    .line 48052
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$MessageEffect;->type:Lorg/drinkless/tdlib/TdApi$MessageEffectType;

    .line 48053
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 48057
    const v0, -0x68d5b6d1

    return v0
.end method
