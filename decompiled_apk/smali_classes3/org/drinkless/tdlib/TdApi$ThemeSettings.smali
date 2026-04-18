.class public Lorg/drinkless/tdlib/TdApi$ThemeSettings;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ThemeSettings"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7357637a


# instance fields
.field public accentColor:I

.field public animateOutgoingMessageFill:Z

.field public background:Lorg/drinkless/tdlib/TdApi$Background;

.field public baseTheme:Lorg/drinkless/tdlib/TdApi$BuiltInTheme;

.field public outgoingMessageAccentColor:I

.field public outgoingMessageFill:Lorg/drinkless/tdlib/TdApi$BackgroundFill;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 50850
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 50851
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$BuiltInTheme;ILorg/drinkless/tdlib/TdApi$Background;Lorg/drinkless/tdlib/TdApi$BackgroundFill;ZI)V
    .locals 0
    .param p1, "builtInTheme"    # Lorg/drinkless/tdlib/TdApi$BuiltInTheme;
    .param p2, "i9"    # I
    .param p3, "background"    # Lorg/drinkless/tdlib/TdApi$Background;
    .param p4, "backgroundFill"    # Lorg/drinkless/tdlib/TdApi$BackgroundFill;
    .param p5, "z8"    # Z
    .param p6, "i10"    # I

    .line 50836
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 50837
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ThemeSettings;->baseTheme:Lorg/drinkless/tdlib/TdApi$BuiltInTheme;

    .line 50838
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$ThemeSettings;->accentColor:I

    .line 50839
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$ThemeSettings;->background:Lorg/drinkless/tdlib/TdApi$Background;

    .line 50840
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$ThemeSettings;->outgoingMessageFill:Lorg/drinkless/tdlib/TdApi$BackgroundFill;

    .line 50841
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$ThemeSettings;->animateOutgoingMessageFill:Z

    .line 50842
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$ThemeSettings;->outgoingMessageAccentColor:I

    .line 50843
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 50847
    const v0, 0x7357637a

    return v0
.end method
