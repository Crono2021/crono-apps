.class public Lorg/drinkless/tdlib/TdApi$MessageVenue;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageVenue"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7ff0de8b


# instance fields
.field public venue:Lorg/drinkless/tdlib/TdApi$Venue;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16908
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16909
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Venue;)V
    .locals 0
    .param p1, "venue"    # Lorg/drinkless/tdlib/TdApi$Venue;

    .line 16899
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16900
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessageVenue;->venue:Lorg/drinkless/tdlib/TdApi$Venue;

    .line 16901
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16905
    const v0, -0x7ff0de8b

    return v0
.end method
