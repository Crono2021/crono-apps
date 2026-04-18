.class public Lorg/drinkless/tdlib/TdApi$MessageChecklist;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageChecklist"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x245abe29


# instance fields
.field public list:Lorg/drinkless/tdlib/TdApi$Checklist;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16368
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16369
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Checklist;)V
    .locals 0
    .param p1, "checklist"    # Lorg/drinkless/tdlib/TdApi$Checklist;

    .line 16359
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16360
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessageChecklist;->list:Lorg/drinkless/tdlib/TdApi$Checklist;

    .line 16361
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16365
    const v0, 0x245abe29

    return v0
.end method
