.class public Lorg/drinkless/tdlib/TdApi$UpdateChatTitle;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateChatTitle"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xa747a5c


# instance fields
.field public chatId:J

.field public title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34368
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34369
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;

    .line 34358
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34359
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatTitle;->chatId:J

    .line 34360
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatTitle;->title:Ljava/lang/String;

    .line 34361
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34365
    const v0, -0xa747a5c

    return v0
.end method
