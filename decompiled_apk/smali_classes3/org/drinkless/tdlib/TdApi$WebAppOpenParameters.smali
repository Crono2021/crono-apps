.class public Lorg/drinkless/tdlib/TdApi$WebAppOpenParameters;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "WebAppOpenParameters"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x51fa466f


# instance fields
.field public applicationName:Ljava/lang/String;

.field public mode:Lorg/drinkless/tdlib/TdApi$WebAppOpenMode;

.field public theme:Lorg/drinkless/tdlib/TdApi$ThemeParameters;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 42176
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 42177
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ThemeParameters;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$WebAppOpenMode;)V
    .locals 0
    .param p1, "themeParameters"    # Lorg/drinkless/tdlib/TdApi$ThemeParameters;
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "webAppOpenMode"    # Lorg/drinkless/tdlib/TdApi$WebAppOpenMode;

    .line 42165
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 42166
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$WebAppOpenParameters;->theme:Lorg/drinkless/tdlib/TdApi$ThemeParameters;

    .line 42167
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$WebAppOpenParameters;->applicationName:Ljava/lang/String;

    .line 42168
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$WebAppOpenParameters;->mode:Lorg/drinkless/tdlib/TdApi$WebAppOpenMode;

    .line 42169
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 42173
    const v0, 0x51fa466f

    return v0
.end method
