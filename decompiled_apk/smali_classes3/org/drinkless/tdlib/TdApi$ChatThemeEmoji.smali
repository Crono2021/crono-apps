.class public Lorg/drinkless/tdlib/TdApi$ChatThemeEmoji;
.super Lorg/drinkless/tdlib/TdApi$ChatTheme;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatThemeEmoji"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6f192a45


# instance fields
.field public name:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 10410
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatTheme;-><init>()V

    .line 10411
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 10401
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatTheme;-><init>()V

    .line 10402
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatThemeEmoji;->name:Ljava/lang/String;

    .line 10403
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 10407
    const v0, -0x6f192a45

    return v0
.end method
