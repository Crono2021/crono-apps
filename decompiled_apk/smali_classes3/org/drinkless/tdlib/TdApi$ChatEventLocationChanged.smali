.class public Lorg/drinkless/tdlib/TdApi$ChatEventLocationChanged;
.super Lorg/drinkless/tdlib/TdApi$ChatEventAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatEventLocationChanged"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x183202b2


# instance fields
.field public newLocation:Lorg/drinkless/tdlib/TdApi$ChatLocation;

.field public oldLocation:Lorg/drinkless/tdlib/TdApi$ChatLocation;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 23864
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 23865
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ChatLocation;Lorg/drinkless/tdlib/TdApi$ChatLocation;)V
    .locals 0
    .param p1, "chatLocation"    # Lorg/drinkless/tdlib/TdApi$ChatLocation;
    .param p2, "chatLocation2"    # Lorg/drinkless/tdlib/TdApi$ChatLocation;

    .line 23854
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 23855
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatEventLocationChanged;->oldLocation:Lorg/drinkless/tdlib/TdApi$ChatLocation;

    .line 23856
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ChatEventLocationChanged;->newLocation:Lorg/drinkless/tdlib/TdApi$ChatLocation;

    .line 23857
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 23861
    const v0, -0x183202b2

    return v0
.end method
