.class public Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeTheme;
.super Lorg/drinkless/tdlib/TdApi$LinkPreviewType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LinkPreviewTypeTheme"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xd7a4b59


# instance fields
.field public documents:[Lorg/drinkless/tdlib/TdApi$Document;

.field public settings:Lorg/drinkless/tdlib/TdApi$ThemeSettings;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 28064
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 28065
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$Document;Lorg/drinkless/tdlib/TdApi$ThemeSettings;)V
    .locals 0
    .param p1, "documentArr"    # [Lorg/drinkless/tdlib/TdApi$Document;
    .param p2, "themeSettings"    # Lorg/drinkless/tdlib/TdApi$ThemeSettings;

    .line 28054
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 28055
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeTheme;->documents:[Lorg/drinkless/tdlib/TdApi$Document;

    .line 28056
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeTheme;->settings:Lorg/drinkless/tdlib/TdApi$ThemeSettings;

    .line 28057
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 28061
    const v0, -0xd7a4b59

    return v0
.end method
