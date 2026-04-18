.class public Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonTypeLoginUrl;
.super Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InlineKeyboardButtonTypeLoginUrl"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x47baa059


# instance fields
.field public forwardText:Ljava/lang/String;

.field public id:J

.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 37798
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonType;-><init>()V

    .line 37799
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;JLjava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "j5"    # J
    .param p4, "str2"    # Ljava/lang/String;

    .line 37787
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonType;-><init>()V

    .line 37788
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonTypeLoginUrl;->url:Ljava/lang/String;

    .line 37789
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonTypeLoginUrl;->id:J

    .line 37790
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonTypeLoginUrl;->forwardText:Ljava/lang/String;

    .line 37791
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 37795
    const v0, -0x47baa059

    return v0
.end method
